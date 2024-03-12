$(function() {
    // 타임리프 값 전달 테스트
    $('.sample_model').html('MODEL_VALUE :: ' + MODEL_VALUE);
    $('.sample_session').html('SESSION_VALUE :: ' + SESSION_VALUE);
    // 통신 테스트
    $.ajax({
        url: 'http://localhost:8081/aips/duncok/test/getSampleList',
        type: 'get',
        success: function (data) {
            console.log(data)
        },
        error: function (error) {
            console.log(error);
        }
    });
});