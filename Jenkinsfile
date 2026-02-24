pipeline {
    agent any 
    
    tools {
        // Specify Maven tool with version 3.8.6
        maven "maven 3.8.6"
    }

    stages {
        stage('Code Checkout') {
            steps {
                // Git checkout step
                git credentialsId: '<Git Credentials>', url: '<GitHub URL>'
            }
        }

        stage('Building the Code') {
            steps {
                // Maven clean and package step
                sh "mvn clean package"
            }
        }

        stage('Build the Image') {
            steps {
                // Docker build step, naming the image using DockerHub repository name and build number
                sh "docker build -t <dockerhubname>/<image name>:${BUILD_NUMBER} ."
            }
        }

        stage('Login and Push the Image') {
            steps {
                // Docker login step
                sh "docker login -u <Username> -p <password>"
                // Docker push step, pushing the image with tagged with build number to DockerHub repository
                sh "docker push <dockerhubname>/<image name>:${BUILD_NUMBER}"
            }
        }
    }
}
