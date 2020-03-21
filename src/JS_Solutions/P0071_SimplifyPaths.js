/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    if(path === '')
        throw 'Empty string is not a legal path';
    let stack = []; 
    if(path.startsWith('/')){
        stack.push('/');
    } 
    let tokens =  path.split('/'); 
    for(let i = 0 ; i < tokens.length ; i++){
        let token = tokens[i];
        if(token === '..' && stack.length !== 0){
              stack.pop();
        } else if(token !== '.' && token !== '' && token !== '..'){
            stack.push(token);
        }
    }
    let spath = '';
    if(stack.length !== 0){
        let prev = stack[0];
        for(let i = 0 ; i < stack.length ; i++){
           if( prev !== '/'){
                spath +='/';
            }
            prev = stack[i]
            spath += prev;
        }
    } else {
        return '/';
    }
    return spath;
};

let path = '/home/';
let spath = simplifyPath(path);
console.log(spath);

path = '/a/./b/../../c/';
spath = simplifyPath(path);
console.log(spath);

path = '/home//foo/';
spath = simplifyPath(path);
console.log(spath);

path = '/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///';
spath = simplifyPath(path);
console.log(spath);

path = '/../';
spath = simplifyPath(path);
console.log(spath);

path = '/home/../../../';
spath = simplifyPath(path);
console.log(spath);