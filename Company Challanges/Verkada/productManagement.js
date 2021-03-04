function ProductManager() {
  this.products = [];

  this.createProduct = function (id, title) {
    // TODO: return false if the product id already exists
    let check = this.findProductById(id);
    
    if(check)
        return false;

    let product = new Object();
    product.id = id;
    product.title = title;
    this.products = [...this.products, product];
    return true;
  };

  this.updateProduct = function (id, title) {
    // TODO: return false if the product doesn't exist
    let check = this.findProductById(id);
    
    if(!check)
        return false;

    const product = this.products.find(product => product.id === id);
    product.id = id;
    product.title = title;
    return true;
  };

  this.deleteProduct = function (id) {
    // TODO: return false if the product doesn't exist
    let check = this.findProductById(id);
    
    if(!check)
        return false;

    const product = this.products.find(product => product.id === id);
    delete product;
    return true;
  };

  this.findProductById = function (id) {
    return this.products.find(product => product.id === id);
  };

  this.findProductByTitle = function (title) {
    return this.products.find(product => product.title === title);
  };
}

const productManager = new ProductManager();

function productManagement(operations) {
  // Calls corresponding methods of productManager based on the input
  return operations.map(operation => {
    const [methodName, ...params] = operation;
    let result = productManager[methodName].call(productManager, ...params);
    return result === undefined ? "null" : JSON.stringify(result);
  });
}