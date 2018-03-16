import React from 'react';

class Login extends React.Component {
    render() {
        return (
            <div className="container formDiv" >
                <form onSubmit={this.props.joinFunction}>
                    <label className="sr-only">Email</label>
                    <input type="email" className="form-control"/>
                    <label className="sr-only">Password</label>
                    <input type="password" className="form-control"/>
                    <button className="btn btn-lg btn-success btn-block">Sign Up</button>
                </form>
                <p className="text-center">Join us now</p>
            </div>
        );
    };
}

export default Login;