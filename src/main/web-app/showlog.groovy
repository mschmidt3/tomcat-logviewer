
String  logdir 	  = context.getInitParameter("logdir")
String  fname     = "${params.file}"
Integer lines     = -1 // "${params.lines}"
Integer firstline = 1
String  filepath  = "${logdir}/${fname}"
def  highlight    = "${params.highlight}".split(',')

if(params.filepath && params.firstline.isInteger()){
	firstline = params.firstline.toInteger()
}

if(fname.contains('..')){
    response.status=404
    println "File: '${fname}'  not found"
} else {

println """
<html>
  <head>
    <title>${fname}</title>
    <link rel="stylesheet" href="css/logviewer.css"></link>
    <script src="js/logviewer.js" ></script>
  </head>
  <body>
    <div class="fileinfo">${fname}</div>
<!--    <div class="debuginfo"> ${request}, ${params}, ${context.getInitParameter("logdir")} </div>  -->
    <a id="top" ></a>
    <a href="#end">jump to end</a>
    <a href="./">back to index</a>
    <div class="showfile"><a id="start" /><pre class="filecontent">"""

  def f = new File(filepath)
  if(f.exists()){
      f.eachLine(firstline){ line ->
        highlight.each{
            line = line.replaceAll(it, "<span class=\"highlight\">${it}</span>")
        }
        println "<code>${line}</code>"
      }
  } else {
      println "File: '${fname}'  not found"
  }

println """</pre>
    <a id="end" ></a>
    <a href="#top">jump to top</a>
    <a href="./">back to index</a>
    </div>
  </body>
</html>
"""

}
