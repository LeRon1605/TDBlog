const chartReader = document.getElementById('chart-reader');
const chartPost = document.getElementById('chart-post');
new Chart(chartReader, {
    type: 'line',
    data: {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3'],
        datasets: [{
            label: 'My First chart',
            data: [2, 4, 6],
            fill: false,
            borderColor: 'rgb(75, 192, 192)'
        }]
    }
});
new Chart(chartPost, {
    type: 'bar',
    data: {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3'],
        datasets: [
            {
                label: 'Đang chờ duyệt',
                data: [1, 2, 3],
                backgroundColor: '#059BFF'
            },
            {
                label: 'Đã xuất bản',
                data: [1, 5, 2],
                backgroundColor: '#22CFCF'
            }
        ],
        options: {
            responsive: true,
            scales: {
                x: {
                    stacked: true,
                }
            }
        }
    }
})
$(document).ready(function() {
    $('select').niceSelect();
});