//count occurence of an element
var str = prompt("Enter the array seperated by commas: ");
var arr = str.split(",");
var target = prompt("Enter the target element: ");
var i, count=0;
for(i=0; i<arr.length; i++){
    if(arr[i] == target){
        count++;
        continue;
    }
}
console.log(count);