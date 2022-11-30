 Validator({
    form: '#form_add-problem',
    formGroupSelector: '.form-group',
    errorSelector: '.form-message',
    rules: [
        Validator.isRequired('#title', 'Vui lòng nhập tên bài viết!'),
        Validator.isRequired('#tag', 'Vui lòng chọn mức độ!'),
        Validator.isRequired('#editor1', 'Vui lòng nhập nội dung!'),
    ],
});
 CKEDITOR.replace('editor1', {
        filebrowserBrowseUrl: 'ckfinder/ckfinder.html',
        filebrowserUploadUrl: 'ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files'
 });
 
 // Image
let inputImage = document.getElementById('inputImage');
let image = document.getElementById('image');

inputImage.onchange = (e) => {
    image.src = URL.createObjectURL(e.target.files[0]);
}