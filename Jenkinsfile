//def gv
pipeline
{
    agent any
    tools {

        maven 'maven-3.8'
    
    }
    stages
    {
        stage("init")
        {
            steps
            {
              echo "Hello"
            }
        }
        stage("Build jar")
        {
            steps
            {
                sh "mvn package"
            
            }
        }
        stage("buildImage")
        {
            steps
            {

            withCredentials([usernamePassword(credentialsId: 'Docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                
                sh 'docker build -t ahmedabdelsalam19/test-app:javaMaven-2.0 .'
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh 'docker push ahmedabdelsalam19/test-app:javaMaven-2.0'

            }
        }
        }
        stage("deploy")
        {
            steps
            {
                echo "thank you"
            }
        }
        }
    post
    {
        always
        {
            echo "this message will appear in all time you build!"
        }
        success
        {
            echo "Hello Genius All Stages build successfully"
        }
        failure
        {
            echo "sorry there are some issues"
        }
    }
}

}