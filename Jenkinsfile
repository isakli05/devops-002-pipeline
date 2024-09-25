pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

        stages {
            stage('Build Maven') {
                steps {
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/isakli05/devops-002-pipeline']])
                    sh 'mvn clean install'
                }
            }

        stage('Unit Test') {
                steps {
                    sh 'echo unit test'
                }
            }

        stage('Docker Image') {
            steps {
                sh 'docker build -t isakaya709/my-application  .'
            }
        }

        stage('Docker Image to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerHub', variable: 'dockerhub')]) {
                        sh 'docker login -u isakaya709 -p ${dockerhub}'
                        sh 'docker push isakaya709/my-application:latest'
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                   kubernetesDeploy configs: 'deploymentservice.yaml', kubeconfigId: 'kubernetes'

                }
            }
        }

        stage('Docker Image to Clean') {
             steps {
                 sh 'docker build -t isakaya709/my-application  .'
             }
        }
    }
}
