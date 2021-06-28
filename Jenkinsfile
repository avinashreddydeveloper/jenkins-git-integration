node {
    stage('Build') {
        withGradle {
    sh './gradlew build'
  }
    }

    stage('Deploy') {
        echo 'Deploying....'
    }
}
