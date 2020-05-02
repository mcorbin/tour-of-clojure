var code = document.getElementById('code');
if(code)
  CodeMirror.fromTextArea(code, {readOnly : true});

var codeResult = document.getElementById('code-result');
if(codeResult)
  CodeMirror.fromTextArea(codeResult, {readOnly : true});
