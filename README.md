# Sam's CS314 TA Website

This website has tutorials and extra study materials for
students in [CS314](https://www.cs.utexas.edu/~scottm/cs314/index.htm).

The website is hosted at [https://www.cs.utexas.edu/~slaberge](https://www.cs.utexas.edu/~slaberge)

## Hugo Site Generator

This website was made with the [Hugo](https://gohugo.io/) 
static site generator and the 
[Hugo book theme](https://themes.gohugo.io/hugo-book/).

If you want to build this site yourself, run it locally using a development
server, or make your own site using Hugo, you'll need to have 
the extended version of Hugo [installed](https://gohugo.io/getting-started/installing/).


### Linux

```
snap install hugo --channel=extended
```

### Windows (with Chocolatey)

```
choco install hugo-extended -confirm
```

### macOS
```
brew install hugo
```

## Live Server

To run a local debug server for the site, run:
```
hugo server
```

## Building the Site

To build the site, simply run:
```
hugo
```

in the repo root directory. The built website files are in the `public` directory.
