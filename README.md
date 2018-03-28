tomcat logviewer
=========================================

a webapp written in groovy


Configuration:
----------------

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
* back to list-link in showlog.groovy
* input fiels for highlight
* first and lastline parameters in showlog.groovy
* check that logfile is in selected path
* download-all logfiles
* about-seite mit version
