# Pubsub Google Cloud function using Java and Gradle

## Running Locally

```shell
./gradlew cloudFunctionRun
```

```shell
curl -v -X "POST" "http://localhost:8083/helloPubSub" \
     -H "Accept: application/json" \
     -H "Content-Type: application/json" \
     -d $'{
  "data":{"data":"eyJuYW1lIjogInRlc3QifQ=="}
}'
```

## Deploying the function

```shell
# Build the uber jar
./gradlew shadowJar

# Deploy the jar
gcloud beta functions deploy java-pubsub-function \
--gen2 \
--runtime java17 \
--trigger-topic=sampletopic \
--entry-point functions.HelloPubSub \
--source ./build/libs/
```