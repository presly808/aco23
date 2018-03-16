import React from 'react';

class Header extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="page-header text-center">
                <h1>{this.props.text}</h1>
            </div>
        );
    };
}

export default Header;