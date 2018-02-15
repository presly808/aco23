function User(name,age){
    this.name = name;
    this.age = age;

    this.hello = function(){
        return " name " + this.name;
    }

}