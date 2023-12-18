pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-id')
        IMAGE_NAME = 'ishakcbn/roomie-backend'
        IMAGE_TAG = 'latest'
        CONTAINER_NAME = "roomie-backend"
    }

    stages {

        stage('Remove Previous Container and Image') {
            steps {
                script {
                    // sh "chmod +x mvnw"
                    // sh "./mvnw clean package -DskipTests"
                    // Check if the container exists and remove it
                    sh "docker stop ${CONTAINER_NAME} 2>NUL || exit 0"
                    sh "docker rm ${CONTAINER_NAME} 2>NUL || exit 0"

                    // Check if the image exists and remove it
                    sh "docker rmi ${IMAGE_NAME} 2>NUL || exit 0"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-id') {
                        docker.image("${IMAGE_NAME}:${IMAGE_TAG}").push()
                    }
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    docker.image("${IMAGE_NAME}:${IMAGE_TAG}").run("-p 8040:8080 --name ${CONTAINER_NAME}")
                }
            }
        }

    }

    post {
        success {
            echo 'Pipeline successfully completed!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
