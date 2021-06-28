node {
    stage('checkout code') {
        checkout scm
    }

    stage('Build jar') {
        withGradle {
            sh './gradlew build'
        }
    }

    stage('Build docker image') {
        sh 'docker build -t avinashch1988/javaapplication .'
    }
}
