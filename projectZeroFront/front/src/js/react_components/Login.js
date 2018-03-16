import React from 'react';

class Login extends React.Component {
    render() {
        return (
            <div className="container formDiv" >
                <form onSubmit={this.props.loginFunction}>
                    <label className="sr-only">Email</label>
                    <input type="email" className="form-control"/>
                    <label className="sr-only">Password</label>
                    <input type="password" className="form-control"/>
                    <button className="btn btn-lg btn-success btn-block" >Sign In</button>
                </form>
                <p className="text-center">New to ProjectZero? <a onClick={this.props.toJoinFunction}>Sign up</a></p>
            </div>
        );
    };
}

export default Login;