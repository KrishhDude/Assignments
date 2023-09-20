//prompt limit
n = prompt("Enter limit: ");

for(var i=1;i<=n;i++){
    if(i%3==0 && i%5==0){
        console.log("FizzBuzz");
        
    }
    else if(i%3==0){
        console.log("Fizz");
    }
    else if(i%5==0){
        console.log("Buzz");
    }
    else if((i+'').indexOf(3)>-1){   //converts i into string, checks if there is any char=3 at some index
        console.log("Fizz");
    }
    else{
        console.log(i);
    }
}