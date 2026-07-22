import sys

from pyspark.ml import Pipeline
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.regression import LinearRegression
from pyspark.sql import SparkSession


spark = SparkSession.builder.appName("ws5-regression").getOrCreate()

input_path = sys.argv[1]

df = (
    spark.read
    .option("header", True)
    .option("inferSchema", True)
    .csv(input_path)
)

df.show()

assembler = VectorAssembler(
    inputCols=["total_bill", "size"],
    outputCol="features",
)

train, test = df.randomSplit([0.8, 0.2], seed=42)

regressor = LinearRegression(
    featuresCol="features",
    labelCol="tip",
)

pipeline = Pipeline(stages=[assembler, regressor])
pipeline_model = pipeline.fit(train)

predictions = pipeline_model.transform(test)

evaluator = RegressionEvaluator(
    labelCol="tip",
    predictionCol="prediction",
)

rmse = evaluator.setMetricName("rmse").evaluate(predictions)
r2 = evaluator.setMetricName("r2").evaluate(predictions)

linear_model = pipeline_model.stages[-1]

print(f"Coefficients: {linear_model.coefficients}")
print(f"Intercept: {linear_model.intercept}")
print(f"RMSE: {rmse}")
print(f"R2: {r2}")

spark.stop()

