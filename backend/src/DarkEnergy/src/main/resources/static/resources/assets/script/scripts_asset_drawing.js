

function initCharts(jsonData){    
    var data =  JSON.parse(jsonData)[0];
    var result = [];

    for(var key in data)
    {
        if(data.hasOwnProperty(key))
        {
            result.push({
                key: key,
                value: data[key]*100
            });
        }
    }
    var template = '';
    
    for(i = 0; i < result.length ; i++ ){
        template = template + '<tr><td class="label-prog">'+result[i].key+'</td><td class="percen">'+ parseFloat(result[i].value).toFixed(2) +'%</td><td class="full"><div class="progressbar"><div class="progressbar--fill" style="width:'+ result[i].value +'%;"></div></div></td></tr>';
    }
    $('#dataPresentation').html(template);
}

function showLoadingImage() {
    $('#inputArea').append('<div id="loading-image"><img src="assets/css/img/ajax-loader.gif" alt="Laden..." /></div>');
}

function hideLoadingImage() {
    $('#loading-image').remove();
}

function loading() {
    // add the overlay with loading image to the page
    var over = '<div id="overlay">' +
        '<img id="loading" src="assets/css/img/ajax-loader.gif">' +
        '</div>';
    $(over).appendTo('body');
}
