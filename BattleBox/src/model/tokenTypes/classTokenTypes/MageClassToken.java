package model.tokenTypes.classTokenTypes;

import model.tokenTypes.ClassToken;

/**
 * The MageClassToken is an extension of the ClassToken for the Mage token.
 */
public class MageClassToken extends ClassToken
{
	@Override
	public String getImageAssetName()
	{
		return "mage.png";
	}
}
