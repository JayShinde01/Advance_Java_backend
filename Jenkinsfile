pipeline {
    agent any

    environment {
        VM_IP = "4.186.24.98"
        VM_USER = "CICDDemo"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/JayShinde01/Advance_Java_backend.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t springboot-app .'
            }
        }

        stage('Save Docker Image') {
            steps {
                bat 'docker save -o springboot-app.tar springboot-app'
            }
        }

        stage('Deploy to Azure VM') {
            steps {
                sshagent(['azure-vm']) {

                    bat """
                    scp springboot-app.tar %VM_USER%@%VM_IP%:/home/%VM_USER%/
                    """

                    bat """
                    ssh %VM_USER%@%VM_IP% ^
                    "docker stop springboot-app || true && ^
                     docker rm springboot-app || true && ^
                     docker load -i /home/%VM_USER%/springboot-app.tar && ^
                     docker run -d --name springboot-app -p 8080:8080 springboot-app"
                    """
                }
            }
        }
    }
}