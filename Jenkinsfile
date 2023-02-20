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
                script {
                    echo "<- welcome , this is init stage ->"
                    //gv = load "script.groovy"
                }
            }
        }
        stage("Build jar")
        {
            steps
            {
                sh "mvn package"
                script {
                    
                    //gv.buildJar()

                }
            }
        }
        stage("buildImage")
        {
            steps
            {

                script {
                    //gv.buildImage()
                }
                withCredentials([
                        usernamePassword(credentials: 'Docker_repo',
                                            usernameVariable: USER ,
                                            passwordVariable: PASSWD)
                    ])
                    {
                        sh " docker build -t ahmedabdelsalam19/test-app:javaMaven-2.0 . "
                        sh " echo ${PASSWD} | docker login -u ${USER} --password-stdin "
                        sh " docker push ahmedabdelsalam19/test-app:javaMaven-2.0 "
                    }
            }
        }
        stage("deploy")
        {
            steps
            {
                script {
                    //gv.deployApp()
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
