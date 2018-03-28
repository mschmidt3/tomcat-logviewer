tomcat logviewer
=========================================

A logviewer-webapp written in groovy


Configuration:
----------------

the default configuration 

* in web.xml

```
    <context-param>
        <param-name>logdir</param-name>
        <param-value>logs</param-value> <!-- directory with logs. -->
    </context-param>
```

```
export GRADLE_HOME=/opt/gradle
export PATH=$GRADLE_HOME/bin:$PATH
```


TODOs
=========================================

* (Basic-) Security configured in web.xml
* Support for multiple log dirs
* back to list-link in showlog.groovy (X)
* input field for highlight
* first and lastline parameters in showlog.groovy
* check that logfile is in selected path (X)
* download-all logfiles
* about-seite mit version (X)
* paging for logfiles

Changes:
=========================================

* 28.03.2018:  back-link, about page, prohibit relative path names
* 24.03.2018:  build with gradle,  ad js and css
* 03.03.2018:  list and display logfiles  

