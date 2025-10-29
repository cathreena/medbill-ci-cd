pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { sh 'mvn -B -DskipTests clean package' }
        }
        stage('Docker Build') {
            steps { sh 'docker build -t medbill-app:${BUILD_NUMBER} .' }
        }
        stage('Smoke Test') {
            steps { sh 'echo "Image medbill-app:${BUILD_NUMBER} built"' }
        }
        stage('Deploy') {
            steps { echo 'Add your deploy steps (push to registry or trigger host)' }
        }
    }
}
