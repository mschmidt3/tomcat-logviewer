
def logdir = context.getInitParameter("logdir")
def fname     = "${params.file}"
def lines     = "${params.lines}"
def firstline = "${params.firstline}"
def filepath  = "${logdir}/${fname}"

println """
<html>
  <head>
    <title>${fname}</title>
    <link rel="stylesheet" href="css/logviewer.css"></link>
    <script src="js/logviewer.js" ></script>
  </head>
  <body>
    <div class="fileinfo">${fname}</div>
    <div class="debuginfo"> ${request}, ${params}, ${context.getInitParameter("logdir")} </div>
    <div class="showfile">
    <pre class="filecontent">
"""
  def f = new File(filepath)
  if(f.exists()){
      f.eachLine{
        println "<code>${it}</code>"
      }
  } else {
      println "File: '${filepath}'  not found"
  }
println """
    </pre>
    </div>
  </body>
</html>
"""
