//Run node code.js
//Open http://localhost:3000/

const fs = require('fs').promises;
const http = require('http');

http.createServer(async (req, res) => {
    var html = '<h1>Before await</h1>';
    
    const data = await fs.readFile('test.csv', 'utf8');
    const rows = data.split('\n');
    
    html += '<table>';
    
    rows.forEach(row => {
      html += '<tr>';
      const columns = row.split(',');
      columns.forEach(col => {
        html += `<td>${col}</td>`;
      });
      html += '</tr>';
    });
    html += '</table>';
    
    html += '<h1>After await</h1>';
    
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(html);
}).listen(3000);
