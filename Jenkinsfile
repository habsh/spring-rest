pipeline {
    agent any
    tools {
        maven "maven388"
        jdk "JDK17"
    }
    stages {
       stage('Git Checkout') {
            steps {
                script {
                    git branch: 'master',                       
                        url: 'https://github.com/habsh/spring-rest.git'
                }
            }
        }
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin;${PATH}"
                echo "M2_HOME = ${M2_HOME}"
            }
        }
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Deploy') {
            steps {
                #bat 'java -jar ./target/Rest1-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
