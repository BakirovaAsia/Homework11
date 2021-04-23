pipeline {
    agent {
        docker {
            image '178.154.214.22:8123/repository/mydockerrepo/buildimage:latest'
            registryUrl 'http://178.154.214.22:8123/repository/mydockerrepo'
            registryCredentialsId '7b949703-9e41-48d1-8a63-972b43b8f986'
            args '-v ./war/:/usr/local/CaucusCalculator/target/'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage ('Get source') {
            steps {
                git 'https://github.com/BakirovaAsia/Homework11.git'
            }
        }
        stage ('Build') {
            steps {
                //sh 'cd ./CaucusCalculator && mvn package'
                sh ' mvn package'
            }
        }
        stage ('Make docker image') {
            steps {
                sh 
                sh 'docker build -t caucuscalc .'
                sh 'docker tag caucuscalc  178.154.214.22:8123/repository/mydockerrepo/caucuscalc:latest  && docker push  178.154.214.22:8123/repository/mydockerrepo/caucuscalc:latest'
            }
        }
        stage ('Deploy image') {
            steps {
                sh 'docker run -d  178.154.214.22:8123/repository/mydockerrepo/caucuscalc:latest'
            }
        }
    }
}
