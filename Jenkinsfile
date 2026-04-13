pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // This ensures Jenkins goes to your specific folder to run Maven
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Runs the JUnit tests for your Inventory logic
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                // Builds the container image
                bat 'docker build -t inventory-management-app .'
            }
        }
        stage('Kubernetes Deploy') {
            steps {
                bat 'kubectl apply -f deployment.yaml --kubeconfig="C:\\Users\\NAVEEN BABU\\.kube\\config" --validate=false'
            }
        }
    }
}