pipeline {
    agent {
        docker {
            image '178.154.214.22:8123/repository/mydockerrepo/buildimage:latest'
            args '-v ./war/:/usr/local/CaucusCalculator/target/'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage ('Get source') {
            git 'https://github.com/jonbos/CaucusCalculator.git'
        }
        stage ('Build') {
            steps {
                //sh 'cd ./CaucusCalculator && mvn package'
                sh ' mvn package'
            }
        }
        stage ('Make docker image') {
            steps {
                sh 'docker build -t caucuscalc .'
                sh 'docker tag caucuscalc  /caucuscalc:latest  && docker push  /caucuscalc:latest'
            }
        }
        stage ('Deploy image') {
            steps {
                sh 'docker run -d   /caucuscalc:latest'
            }
        }
    }
}
