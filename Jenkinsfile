pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy to Staging') {
            steps {
                input message: 'Tests passed and artifact built. Deploy to staging?'
                echo 'Deploying to staging... (simulated)'
                echo "Deployed build #${env.BUILD_NUMBER} to staging."
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}

