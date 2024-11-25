pipeline {
    agent any
    tools {
        maven 'MAVEN 3.3.9'
        jdk 'jdk8'
    }
    environment {
        AWS_REGION = 'us-east-1'           // Your AWS region
        ECR_REPOSITORY = 'appointment-app' // Your ECR repository name
        ECR_URI = "612349341052.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPOSITORY}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    // Run Maven build
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run Maven tests
                    sh 'mvn test'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    sh '''
                    docker build -t $ECR_URI .
                    '''
                }
            }
        }
        stage('Login to ECR') {
            steps {
                script {
                    // Log into AWS ECR
                    sh '''
                    aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $ECR_URI
                    '''
                }
            }
        }
        stage('Push Docker Image to ECR') {
            steps {
                script {
                    // Push the image to ECR
                    sh 'docker push $ECR_URI'
                }
            }
        }
    }
    post {
        success {
            echo 'Build and Deployment succeeded!'
        }
        failure {
            echo 'Build or Deployment failed.'
        }
    }
}
