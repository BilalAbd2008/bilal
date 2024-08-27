document.getElementById('pertanyaan').addEventListener('submit', function(event) {
    event.preventDefault();
    const hcaptchaResponse = hcaptcha.getResponse();
    if (!hcaptchaResponse) {
        alert('Harap selesaikan hCaptcha');
        return;
    }
    
    // Tambahkan respons hCaptcha ke dalam data form
    const formData = new FormData(this);
    formData.append('h-captcha-response', hcaptchaResponse);
    
    // Kirim data form
    fetch(this.action, {
        method: 'POST',
        body: formData
    }).then(response => response.json()).then(data => {
        // Tangani respons
        console.log(data);
    }).catch(error => {
        // Tangani error
        console.error('Error:', error);
    });
});
