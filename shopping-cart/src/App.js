import React, { Component } from 'react';
import logo from './logo.svg';

class App extends Component {

  constructor(props) {
    super(props);
    this.addToCart = this.addToCart.bind(this);
    this.state = {
      products : [],
      isLoaded : false,
    }
  }

  
  componentDidMount() {
    fetch('http://localhost:8080/product/all')
    .then(res => res.json())
    .then(json => {
      this.setState({
        isLoaded : true,
        products : json,
      })

    });
  }

  addToCart() {
    console.log("Hi");
  }
  

  render() {

    var {isLoaded, products} = this.state;

    console.log(products)

    if (!isLoaded) {
      return <div>products Loading....... </div>
    } else {
      return (
        <div className="App">
          <h1>Products </h1>
          <br/>
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Price</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              { products.map(function(product, index){
                return (
                <tr key={product.productId}>
                  <td>{product.name}</td>
                  <td>{product.price}</td>
                  <td><input type="submit" value="Add to Cart" onClick={() => this.addToCart()}/></td>
                </tr>)
              })

              }
            </tbody>

          </table>
          {/* <ul>
            {products.map(product => (
                <li key={product.productId}>
                    {product.name} <button>Add to Cart</button>
                </li>
            ))};
          </ul> */}
        </div>
      );
    }
  }
}

export default App;
