def gv
pipeline
{
    agent any
    tools
    {
        maven = 'maven-3.8'
    }
    stages
    {
        stage("init")
        {
            steps
            {
                echo "<- welcome , this is init stage ->"
                gv = load "script.groovy"
            }
        }
        stage("Build jar")
        {
            steps
            {
                grv.buildJar()
            }
        }
        stage("buildImage")
        {
            steps
            {
                gv.buildImage()
            }
        }
        stage("deploy")
        {
            steps
            {
                gv.deployApp()
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
