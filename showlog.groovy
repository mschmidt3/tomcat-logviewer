
def logdir = context.getInitParameter("logdir")
def fname     = "${params.file}"
def lines     = "${params.lines}"
def firstline = "${params.firstline}"
def filepath  = "${logdir}/${fname}"
def highlight = "${params.highlight}".split(',')

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
    <a href="#end">end</a>
    <div class="showfile"><a id="start" /><pre class="filecontent">
"""
  def f = new File(filepath)
  if(f.exists()){
      f.eachLine{ line ->
        highlight.each{
            line = line.replaceAll(it, "<span class=\"highlight\">${it}</span>")
        }
        println "<code>${line}</code>"
      }
  } else {
      println "File: '${filepath}'  not found"
  }
println """
    </pre>
    <a id="end" ></a>
    </div>
  </body>
</html>
"""
