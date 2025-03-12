
window.onload = function(){
    let i = document.querySelector("#ham")
    // 값이 null인 이유를찾자
    console.log(i)
    // console.log(h)
    
    
    
    
    document.querySelector("#ham").addEventListener("click", op)
    function op(e){
        console.log('gg')
        let yn = e.target.checked
        // oac1 = true;
        if(yn == "false"){
                // 쿠키설정
                const now = new Date();
                console.log(now)
                console.log(oac1)

                document.cookie = "oac1=true";
                // console.log(j)
            }
        }
    }