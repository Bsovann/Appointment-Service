pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1' // Set your AWS Region
        REPO_NAME = 'appointment-app' // Set your ECR repository name
        DOCKER_IMAGE = "${REPO_NAME}:latest"
        AWS_CREDENTIALS = 'AKIAY5EW5NV6AQPV7NVD' // Jenkins AWS credentials ID
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo 'Running Tests...'
                sh './gradlew test' // Update to your testing command
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Login to ECR') {
            steps {
                script {
                    withAWS(credentials: AWS_CREDENTIALS, region: AWS_REGION) {
                        sh '''
                        aws ecr get-login-password --region $AWS_REGION | \
                        docker login --username AWS --password-stdin 612349341052.dkr.ecr.$AWS_REGION.amazonaws.com
                        '''
                    }
                }
            }
        }

        stage('Push to ECR') {
            steps {
                script {
                    sh "docker tag $DOCKER_IMAGE 612349341052.dkr.ecr.$AWS_REGION.amazonaws.com/$DOCKER_IMAGE"
                    sh "docker push 612349341052.dkr.ecr.$AWS_REGION.amazonaws.com/$DOCKER_IMAGE"
                }
            }
        }
    }

    post {
        always {
            cleanWs() // Clean up workspace
        }
    }
}
