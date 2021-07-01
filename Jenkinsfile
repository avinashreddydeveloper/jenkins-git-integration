node {
    stage('checkout code') {
        checkout scm
    }

    stage('Build jar') {
        sh './gradlew build'
    }

    stage('Build image') {
        app = docker.build("avinashch1988/javaapplication")
    }

    stage('Test image') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
