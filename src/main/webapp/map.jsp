<!DOCTYPE html>
<html class='use-all-space'>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta charset='UTF-8'>
    <title>Maps SDK for Web - Changing map centre</title>
    <meta name='viewport' content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no'/>
    <link rel='stylesheet' type='text/css' href='sdk/map.css'/>
    <link rel='stylesheet' type='text/css' href='elements.css'/>
    <script type='text/javascript' src='js/form.js'></script>
    <script type='text/javascript' src='sdk/tomtom.min.js'></script>
</head>
<body class='use-all-space'>
    <div id='map' class='use-all-space'></div>
    <script>
        // Define your product name and version
        tomtom.setProductInfo('<your-product-name>', '<your-product-version>');
        tomtom.map('map', {
            center: [52.379189, 4.899431],
            zoom: 12,
            source: 'vector',
            key: 'D5IYmsgLaSB7BkLe9jgyhDA923FgG0mS',
            basePath: '/sdk'
        });
    </script>
</body>
</html>