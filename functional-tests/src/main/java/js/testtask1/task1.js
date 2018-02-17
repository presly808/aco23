var z = 23;

function sum(a, b){
    return a + b;
}

function errorTest(){
    throw new Error("Some message");
}

function testFunction(func,num){
    return func(num)
}

function testBiFunction(func,a,b){
    return func(a,b)
}

print(z);