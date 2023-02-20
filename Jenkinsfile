def gv
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
                script {
                    echo "<- welcome , this is init stage ->"
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build jar")
        {
            steps
            {
                script {
                    gv.buildJar()

                }
            }
        }
        stage("buildImage")
        {
            steps
            {

                script {
                    gv.buildImage()
                }
                withCredentials([
                        usernamePassword(credentials: 'Docker_repo',
                                            usernameVariable: USERNAME ,
                                            passwordVariable: PASSWORD)
                    ])
                    {
                        sh " docker build -t ahmedabdelsalam19/test-app:javaMaven-2.0 . "
                        sh " echo $PASSWORD | docker login -u $USERNAME --password-stdin "
                        sh " docker push ahmedabdelsalam19/test-app:javaMaven-2.0 "
                    }
            }
        }
        stage("deploy")
        {
            steps
            {
                script {
                    gv.deployApp()
                }
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
