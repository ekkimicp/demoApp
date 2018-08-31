# demoApp
A sample web application for TA migration demo purpose.
(used internally for education, and externally for sales team)

Description: 
It is a resort chain (not real), and the potential travellers are using this web application to check the weather conditions for different resort locations around the world, so they can decide if it is a good time to go. We want to demo the process of migrating this web application from an on-prem server (i.e. WAS server) to IBM Cloud private. 

The web application end result should look similar to this: https://github.ibm.com/TransformationAdvisor/demoApp/issues/2


# Migration Steps

### ModResorts.war is a web application used for TA migration demo purpose. 
The basic flow of migration is as follows: 

* Download the demoApp war file from [here](https://github.ibm.com/TransformationAdvisor/demoApp/releases) (use the latest version): 

* Download [the sample artifacts ](https://github.ibm.com/TransformationAdvisor/development-tasks/files/187299/ResortsDemoArtifacts.zip)for ModResorts sample application. Otherwise, generate the data collector zip file on TA directly by running the collector against your WAS environment. 

* Upload the zip file mentioned in the above step to view the migration plans in TA.

* Upload the modResorts binary to the migration plan.

* Deploy to ICP with button. During this process, you need to specify: GitHub repo URL, GitHub credentials, ICp microclimate, instance name, etc.

* Check the ICP deployment to see if it's running. Launch the migrated instance and it should show you a liberty server running. Go to the context root /resorts to access the demoApp. 
