const chartReader = document.getElementById('chart-reader');
const chartPost = document.getElementById('chart-post');
new Chart(chartReader, {
    type: 'line',
    data: {
        labels: data.labels,
        datasets: [{
            label: 'Người dùng mới',
            data: data.users,
            fill: false,
            borderColor: 'rgb(75, 192, 192)'
        }]
    }
});
new Chart(chartPost, {
    type: 'bar',
    data: {
        labels: data.labels,
        datasets: [
            {
                label: 'Đang chờ duyệt',
                data: data.states.processing,
                backgroundColor: '#059BFF'
            },
            {
                label: 'Đã xuất bản',
                data: data.states.publish,
                backgroundColor: '#22CFCF'
            },
            {
                label: 'Đã cấm',
                data: data.states.ban,
                backgroundColor: '#FF4069'
            }
        ],
    },
    options: {
            responsive: true,
            scales: {
                x: {
                    stacked: true,
                }
            }
    }
})
$(document).ready(function() {
    $('select').niceSelect();
});