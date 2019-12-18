<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>Archivator</title>
      <link rel='stylesheet' href='style.css' type='text/css' media='all' />
  </head>
  <body>
    <table>
        <thead>
            <th>1</th>
            <th>2</th>
            <th>3</th>
        </thead>
        <tbody>
        <form action="/archive" enctype="multipart/form-data" name="archive" method="POST">
            <tr>
                <td><label for="files">Select files for archivating:</label></td>
                <td><input class="longelements" type="file" name="files" id="files" multiple></td>
                <td><input type="submit" /></td>
            </tr>
        </form>
        </tbody>
    </table>
  </body>
</html>
