pipeline{
    tools{
        maven 'Maven3'
        jdk 'JDK17'
    }
    environment{
        SONARQUBE_ENV='sonarQube'
        DOCKER_IMAGE='todo:latest'
    }
    stages{
        stage('checkout code'){
            steps{
                git branch:'main'
                url: 'https://github.com/sas7sahu/TodoApp.git'
            }
        }
        stage('test'){
            steps{
                sh 'mvn clean test'
            }
        }
        stage('sonar analysis'){
            steps{

            }
        }
        stage('quality gate'){

        }
        stage('bbuild docker image'){
            steps{
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }
        
    }
}