export default (paramString, key) => {
  return decodeURIComponent(
    paramString.replace(
      new RegExp(
        '^(?:.*[&\\?]' +
        encodeURIComponent(key).replace(/[.+*]/g, '\\$&') +
        '(?:\\=([^&]*))?)?.*$', 'i'
      ),
      '$1'
    )
  )
}